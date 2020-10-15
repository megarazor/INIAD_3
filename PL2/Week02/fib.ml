let rec fib1 n =
  if n = 0 then 0
  else if n = 1 then 1
  else fib1 (n - 1) + fib1 (n - 2)
;;

(* fib1 0;;
fib1 1;;
fib1 2;;
fib1 3;;
fib1 4;;
fib1 5;;
fib1 6;;
fib1 7;;
fib1 8;;
fib1 9;;
fib1 10;; *)

let rec fib2 n =
  let rec iter a b i =
    if i >= n then a
    else 
      iter b (a + b) (i + 1)
  in iter 0 1 0
;;

(* fib1 40;;
fib2 40;; *)

fib2 0;;
fib2 1;;
fib2 2;;
fib2 3;;
fib2 4;;
fib2 5;;
fib2 6;;
fib2 7;;
fib2 8;;
fib2 9;;
fib2 10;;
fib2 11;;
fib2 12;;
fib2 13;;
fib2 14;;
fib2 15;;
fib2 16;;
fib2 17;;
fib2 18;;
fib2 19;;
fib2 20;;

let matrix_mul (m : int list) (n : int list) = 
  match m with 
    m0::m1::m2::m3::_ -> 
      match n with
        n0::n1::n2::n3::_ -> [(m0*n0 + m1*n2); (m0*n1 + m1*n3); (m2*n0 + m3*n2); (m2*n1 + m3*n3)]
;;

(* matrix_mul [1;1;1;0] [1;1;1;0];; 
matrix_mul [1;1;1;0] (matrix_mul [1;1;1;0] [1;1;1;0]);;
matrix_mul (matrix_mul [1;1;1;0] [1;1;1;0]) (matrix_mul [1;1;1;0] [1;1;1;0]);;
matrix_mul ([1;1;1;0]) (matrix_mul (matrix_mul [1;1;1;0] [1;1;1;0]) (matrix_mul [1;1;1;0] [1;1;1;0]));;

matrix_mul (matrix_mul [1;1;1;0] [1;1;1;0]) (matrix_mul (matrix_mul [1;1;1;0] [1;1;1;0]) (matrix_mul [1;1;1;0] [1;1;1;0]));;
matrix_mul [1;1;1;0] (matrix_mul (matrix_mul [1;1;1;0] [1;1;1;0]) (matrix_mul (matrix_mul [1;1;1;0] [1;1;1;0]) (matrix_mul [1;1;1;0] [1;1;1;0])));;
matrix_mul (matrix_mul (matrix_mul [1;1;1;0] [1;1;1;0]) (matrix_mul [1;1;1;0] [1;1;1;0])) (matrix_mul (matrix_mul [1;1;1;0] [1;1;1;0]) (matrix_mul [1;1;1;0] [1;1;1;0]));; *)

(* matrix_mul [2;4;9;2] [5;8;1;7];;
result: 14	44	47	86 *)

let fib3 n = 
  if n <= 0 then 0
  else
    begin
      let rec iter mtrx n' = 
        if n' <= 0 then [1;0;0;1]
        else if n' mod 2 = 0 then iter (matrix_mul mtrx mtrx) (n' / 2)
        else matrix_mul mtrx (iter mtrx (n' - 1))
      in match iter [1;1;1;0] (n - 1) with
        hd::tl -> hd
      | [] -> 0
    end
;; 

let fibm n = 
  if n <= 0 then [0;0;0;0]
  else
    begin
      let rec iter mtrx n' = 
        if n' <= 0 then [1;0;0;1]
        else if n' mod 2 = 0 then iter (matrix_mul mtrx mtrx) (n' / 2)
        else matrix_mul mtrx (iter mtrx (n' - 1))
      in iter [1;1;1;0] (n - 1)
    end
;; 

fib3 0;;
fib3 1;;
fib3 2;;
fib3 3;;
fib3 4;;
fib3 5;;
fib3 6;;
fib3 7;; (* false *)
fib3 8;;
fib3 9;;
fib3 10;;
fib3 11;; (* false *)
fib3 12;;
fib3 13;;
fib3 14;;
fib3 15;;
fib3 16;;
fib3 17;;
fib3 18;;
fib3 19;;
fib3 20;;

(* fib3 7;;
fib3 6;;
fib3 8;; *)

(* fibm 0;;
fibm 1;;
fibm 2;;
fibm 3;;
fibm 4;;
fibm 5;;
fibm 6;;
fibm 7;; (* false *)
fibm 8;;
fibm 9;;
fibm 10;;
fibm 11;; (* false *)
fibm 12;;
fibm 13;;
fibm 14;;
fibm 15;;
fibm 16;;
fibm 17;;
fibm 18;;
fibm 19;;
fibm 20;; *)