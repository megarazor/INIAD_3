let rec pow a n = 
  let rec pow_iter result a n =
    if n <= 0 then result
    else
      let result'= result * a in
        pow_iter result' a (n - 1)
  in pow_iter 1 a n
;;

pow 3 4;;
pow 2 10;;