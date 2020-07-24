exception Type_mismatch

type value =
    String of string    (* string value *)
  | Int of int          (* integer value *)

type expr = 
    Add of expr * expr  (* a + b *)
  | Sub of expr * expr  (* a - b *)
  | Const of value      (* constant value *)

let rec eval expr =
  match expr with
    Add(e1, e2) ->
      begin
        match e1, e2 with
          Const(c1), Const(c2) -> 
            begin
              match c1, c2 with
                String(s1), String(s2) -> Const(String(s1 ^ s2))
              | Int(i1), Int(i2) -> Const(Int(i1 + i2))
              | _, _ -> raise Type_mismatch
            end
        | left, right -> eval (Add(left, right))
      end
  | Sub(e1, e2) ->
    begin
      match e1, e2 with
        Const(c1), Const(c2) -> 
          begin
            match c1, c2 with
              String(s1), String(s2) -> raise Type_mismatch
            | Int(i1), Int(i2) -> Const(Int(i1 - i2))
            | _, _ -> raise Type_mismatch
          end
      | left, right -> eval (Sub(left, right))
    end
  | Const(c) -> Const(c)
;;

eval (Add(Const(Int(1)), Const(Int(2))));;
(* - : value = Int 3 *)
eval (Add(Const(String("ini")), Const(String("ad"))));;
(* - : value = String "iniad" *)
(* eval (Sub(Const(String("ini")), Const(String("ad"))));; *)
(* Exception: Type_mismatch. *)
eval (Sub(Const(Int(1)), Const(Int(2))));;
eval (Add(Const(String("ini")), Const(Int(1))));;