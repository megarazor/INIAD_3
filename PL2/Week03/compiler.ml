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

let compile exp =
  let rec iter result exp' =
    match exp' with
      Number(n) -> result @ [Push(n)]
    | Binop(op, left, right) when op = '+' -> result @ iter result left @ iter result right @ [Add]
    | Binop(op, left, right) when op = '-' -> result @ iter result left @ iter result right @ [Sub]
    | Binop(op, left, right) when op = '*' -> result @ iter result left @ iter result right @ [Mul]
    | Binop(op, left, right) -> result @ iter result left @ iter result right @ [Div]
  in iter [] exp
;;

compile (Number(1));;
compile (Binop('+', Number(1), Binop('*', Number(2), Number(3))));;
compile (Binop('+', Number(1), Number(2)));;
compile (Binop('-', Binop('*', Number(2), Binop('+', Number(9), Number(13))), Binop('/', Number(2), Number(3))));;