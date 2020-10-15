let rec find_gcd a b =
  if (a mod b = 0) then b
  else find_gcd b (a mod b) ;;

let gcd a b =
  if (a > b) then find_gcd a b
  else find_gcd b a ;;

gcd 36 18;;