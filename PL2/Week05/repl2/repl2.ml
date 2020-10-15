(* Compiler *)

type expression = 
  Binop of char * expression * expression
| Number of int;;

type instruction = 
  Add
| Sub
| Mul
| Div
| Push of int
;;

let compile expr =
  let stack = MyStack.create () in 
    let rec iter exp =
      match exp with
        Number(n) -> MyStack.push (Push(n)) stack
      | Binop(op, left, right) when op = '+' -> iter left; iter right; MyStack.push Add stack
      | Binop(op, left, right) when op = '-' -> iter left; iter right; MyStack.push Sub stack
      | Binop(op, left, right) when op = '*' -> iter left; iter right; MyStack.push Mul stack
      | Binop(op, left, right) -> iter left; iter right; MyStack.push Div stack
    in iter expr; stack
;;

(* REPL *)

exception SyntaxError;;
exception ZeroDivision;;

let rec eval stk =
  match MyStack.pop stk with
    Push(n) -> n
  | Add -> (eval stk) + (eval stk) 
  | Sub ->
      let b = eval stk and a = eval stk in a - b
  | Mul -> (eval stk) * (eval stk) 
  | Div ->
      let den = eval stk and num = eval stk in
        if den = 0 then raise ZeroDivision
        else num / den
;;

let parse expr =
  let expr = 
    let r = ref "" in
    String.iter (fun c -> if c <> ' ' then r := !r ^ (String.make 1 c) else ()) expr;
    !r
  in let len = String.length expr in
  let rec parse_addsub pos =
    let rec iter (pos, e) =
      if pos >= len then pos, e
      else match expr.[pos] with
          '+' | '-' as op ->
          let pos, e2 = parse_muldiv (pos+1) in iter (pos, Binop(op, e, e2))
        | _ -> (pos, e)
    in iter (parse_muldiv pos)
  and parse_muldiv pos =
    let rec iter (pos, e) =
      if pos >= len then pos, e
      else match expr.[pos] with
          '*' | '/' as op ->
          let pos, e2 = parse_simple (pos+1) in iter (pos, Binop(op, e, e2))
        | _ -> (pos, e)
    in iter (parse_simple pos)
  and parse_simple pos =
    if pos >= len then raise SyntaxError
    else match expr.[pos] with
        '(' ->
        let pos, head = parse_addsub (pos+1) in
        if pos >= len || expr.[pos] <> ')' then raise SyntaxError
        else (pos+1), head
      | c when c >= '0' && c <= '9' ->
        let char_of_int c = Char.code c - Char.code '0' in
        let rec iter (pos, v) =
          if pos >= len || expr.[pos] < '0' || expr.[pos] > '9' then (pos, v)
          else iter (pos+1, v * 10 + char_of_int expr.[pos])
        in let (pos, v) = iter (pos+1, char_of_int c)
        in pos, Number(v)
      | _ -> raise SyntaxError
  in let pos, head = parse_addsub 0 in
  if pos < len then raise SyntaxError
  else head
;;


let rec repl () =
  Printf.printf ">>> ";
  try
    let line= read_line () in
      let expr= parse line in
        let stack= compile expr in
          print_int (eval stack); Printf.printf "\n"; repl ()
  with
    ZeroDivision -> print_endline "ERROR: division by zero"; repl ()
  | SyntaxError -> print_endline "ERROR: syntax error"; repl ()
  | _ -> print_endline "ERROR: unknown error";
;;

let _ = repl();;