(* simple type-checking *)

type pyvalue =
    IntVal of int
  | StrVal of string
  | FloatVal of float

type pytype =
    IntType
  | StrType
  | FloatType

type pyexpr =
    Add of pyexpr * pyexpr  (* e1 + e2 *)
  | Mul of pyexpr * pyexpr  (* e1 * e2 *)
  | Value of pyvalue

let rec str_concat_n_times n str =
  if n = 0 then "" else str ^ str_concat_n_times (n - 1) str

(* program execution *)
let rec eval_expr = function
    Add(e1, e2) ->
    begin
      match eval_expr e1, eval_expr e2 with
        IntVal(v1), IntVal(v2) -> IntVal(v1 + v2)
      | StrVal(v1), StrVal(v2) -> StrVal(v1 ^ v2)
      | FloatVal(v1), FloatVal(v2) -> FloatVal(v1 +. v2)
      | FloatVal(f), IntVal(i) | IntVal(i), FloatVal(f) -> FloatVal(f +. (float_of_int i))
      | _ -> failwith "type error"
    end
  | Mul(e1, e2) ->
    begin
      match eval_expr e1, eval_expr e2 with
        IntVal(v1), IntVal(v2) -> IntVal(v1 * v2)
      | FloatVal(v1), FloatVal(v2) -> FloatVal(v1 *. v2)
      | FloatVal(f), IntVal(i) | IntVal(i), FloatVal(f) -> FloatVal(f *. (float_of_int i))
      | IntVal(n), StrVal(s) | StrVal(s), IntVal(n) -> StrVal(str_concat_n_times n s)
      | _ -> failwith "type error"
    end
  | Value(v) -> v

(* type checking *)
let rec type_expr = function
    Add(e1, e2) ->
    begin
      match type_expr e1, type_expr e2 with
        IntType, IntType -> IntType
      | StrType, StrType -> StrType
      | FloatType, FloatType -> FloatType
      | FloatType, IntType | IntType, FloatType -> FloatType
      | _ -> failwith "type error"
    end
  | Mul(e1, e2) ->
    begin
      match type_expr e1, type_expr e2 with
        IntType, IntType -> IntType
      | FloatType, FloatType -> FloatType
      | FloatType, IntType | IntType, FloatType -> FloatType
      | IntType, StrType | StrType, IntType -> StrType
      | _ -> failwith "type error"
    end
  | Value(IntVal(_)) -> IntType
  | Value(StrVal(_)) -> StrType
  | Value(FloatVal(_)) -> FloatType


(* type of 1 + 2 *)
let t1 = type_expr (Add(Value(IntVal(1)), Value(IntVal(2))))

(* type of 1.5 + 3.7 *)
let t3 = type_expr (Add(Value(FloatVal(1.5)), Value(FloatVal(3.7))))

(* type of 1.5 * 3.7 *)
let t4 = type_expr (Mul(Value(FloatVal(1.5)), Value(FloatVal(3.7))))

(* type of 1 + 3.7 *)
let t5 = type_expr (Add(Value(IntVal(1)), Value(FloatVal(3.7))))

(* type of 3.7 + 1 *)
let t6 = type_expr (Add(Value(FloatVal(3.7)), Value(IntVal(1))))

(* type of 3 * "abc" *)
let t7 = type_expr (Mul(Value(IntVal(3)), Value(StrVal("abc"))))

(* type of 3.7 * "abc" *)
(* should be type_error *)
let t8 = type_expr (Mul(Value(FloatVal(3.7)), Value(StrVal("abc"))))