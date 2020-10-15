let rec pow a n = 
  if (n <= 0) then 1
  else if (n mod 2 = 0) then pow (a * a) (n / 2)
  else a * pow a (n - 1)
;;

pow 3 4;;
pow 2 10;;

(* 
let pow a n =
  if (n = 0) then 1
  else if (n mod 2 = 0) then pow_calc (a * a) (n / 2)
  else a * pow_calc  *)