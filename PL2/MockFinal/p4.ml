type expr = 
  Add of expr * expr  (* addition *)
| Mul of expr * expr  (* multiplication *)
| Val of float        (* constant *)
| Var of string       (* variable *)

let rec fold_const expr =
  let rec fold e =
    match e with
      Val(v) -> Val(v)
    | Var(x) -> Var(x)
    | Add(e1, e2) ->
      begin
        match e1, e2 with
          Val(v1), Val(v2) -> Val(v1 +. v2)
        | expr1, expr2 -> Add(fold expr1, fold expr2)
      end
    | Mul(e1, e2) ->
      begin
        match e1, e2 with
          Val(v1), Val(v2) -> Val(v1 *. v2)
        | expr1, expr2 -> Mul(fold expr1, fold expr2)
      end
  in
  begin
    let folded1= fold expr in
      let folded2= fold (fold expr) in
        if folded1 = folded2 then folded1
        else fold_const (folded2)
  end
;;

fold_const (Add(Mul(Var("x"), Val(1.)), Mul(Val(2.), Add(Val(3.), Val(4.)))));;
fold_const (Add(Add(Mul(Var("x"), Val(10.)), Val(2.)), Mul(Mul(Val(3.), Var("y")), Add(Mul(Val(5.), Val(6.)), Add(Val(8.), Add(Val(1.), Val(3.)))))));;