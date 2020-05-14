(* Supports <>, <=, >= so uses string instead of char *)
type expression = 
  Binop of string * expression * expression
| Number of int;;

let rec eval exp =
match exp with
  Binop(c, e1, e2) when c = "?" ->
    begin
      if eval e1 > 0 then
        match e2 with
          Binop(c', e1', _) when c' = ":" -> eval(e1')
      else
        match e2 with
          Binop(c', _, e2') when c' = ":" -> eval(e2')
    end
| Binop(c, e1, e2) when c = "=" -> 
    if eval e1 = eval e2 then 1
    else 0
| Binop(c, e1, e2) when c = ">" -> 
    if eval e1 > eval e2 then 1
    else 0
| Binop(c, e1, e2) when c = "<" -> 
    if eval e1 < eval e2 then 1
    else 0
| Binop(c, e1, e2) when c = "<=" -> 
    if eval e1 <= eval e2 then 1
    else 0 
| Binop(c, e1, e2) when c = "<>" -> 
    if eval e1 <> eval e2 then 1
    else 0
| Binop(c, e1, e2) when c = ">=" -> 
    if eval e1 >= eval e2 then 1
    else 0      
| Binop(c, e1, e2) when c = "+" -> eval(e1) + eval(e2)
| Binop(c, e1, e2) when c = "-" -> eval(e1) - eval(e2)
| Binop(c, e1, e2) when c = "*" -> eval(e1) * eval(e2)
| Binop(c, e1, e2) -> eval(e1) / eval(e2)
| Number(n) -> n
;;

eval (Binop("+", Number(1), Binop("*", Number(2), Number(3))));;
eval (Binop("?", Binop("+", Number(-3), Number(2)), Binop(":", Number(2), Binop("*", Number(7), Number(2)))));;
eval (Binop("?", Binop("<", Number(-3), Number(2)), Binop(":", Number(2), Binop("*", Number(7), Number(2)))));;
eval (Binop("?", Binop(">", Number(-3), Number(2)), Binop(":", Number(2), Binop("*", Number(7), Number(2)))));;
eval (Binop("?", Binop("=", Number(-1), Number(2)), Binop(":", Number(2), Binop("*", Number(7), Number(2)))));;
eval (Binop("?", Binop("<>", Number(-1), Number(-1)), Binop(":", Number(2), Binop("*", Number(7), Number(2)))));;
eval (Binop("?", Binop(">=", Number(-1), Number(2)), Binop(":", Number(2), Binop("*", Number(7), Number(2)))));;
eval (Binop("?", Binop("<=", Number(-1), Number(2)), Binop(":", Number(2), Binop("*", Number(7), Number(2)))));;
eval (Binop("?", Binop(">=", Number(2), Number(2)), Binop(":", Number(2), Binop("*", Number(7), Number(2)))));;