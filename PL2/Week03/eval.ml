type expression = 
  Binop of char * expression * expression
| Number of int;;

let rec eval exp =
  match exp with
    Binop(c, e1, e2) when c = '+' -> eval(e1) + eval(e2)
  | Binop(c, e1, e2) when c = '-' -> eval(e1) - eval(e2)
  | Binop(c, e1, e2) when c = '*' -> eval(e1) * eval(e2)
  | Binop(c, e1, e2) -> eval(e1) / eval(e2)
  | Number(n) -> n
;;

eval (Binop('+', Number(1), Binop('*', Number(2), Number(3))));;

(* let rec eval2 exp =
  match exp with
    Binop(c, e1, e2) when c = '+' -> eval2(e1) + eval2(e2)
  | Binop(c, e1, e2) when c = '-' -> eval2(e1) - eval2(e2)
  | Binop(c, e1, e2) when c = '*' -> eval2(e1) * eval2(e2)
  | Binop(c, e1, e2) when c = '/' -> eval2(e1) / eval2(e2)
  | Number(n) -> n
;; *)