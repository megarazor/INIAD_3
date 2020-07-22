type expr =
  Add of expr * expr
| Mul of expr * expr
| Val of int
| X              (* variable x *)

let rec eval_expr expr x =
  match expr with
    Val(v) -> v
  | Add(e1, e2) -> (eval_expr e1 x) + (eval_expr e2 x)
  | Mul(e1, e2) -> (eval_expr e1 x) * (eval_expr e2 x)
  | X -> x
;;

eval_expr (Add(Val(2), Mul(Val(3), X))) 4;;    (* 2 + 3 * x *)