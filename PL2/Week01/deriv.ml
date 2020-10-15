let deriv f =
  let 
    delta_x = 0.0001
  in
    fun x -> (f(x +. delta_x) -. f(x)) /. delta_x
;;

let f x = x ** 2.0 ;;
let f' = deriv f;;
f' 10.0;;
