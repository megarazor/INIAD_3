let rec apply f n =
  let rec iter newf i =
    if i <= 0 then 
      newf
    else
      iter (fun x -> f (newf x)) (i - 1)
  in iter f n
;;

let mysqrt v =
  let f x =
    x *. x -. v
  in
  let df x = 
    2.0 *. x
  in
  let newton_map x =
    x -. f(x) /. df(x)
  in
  let iter_newton = 
    apply newton_map 10000
  in iter_newton v
;;

mysqrt 2.0;;
mysqrt 3.0;;
mysqrt 4.0;;
mysqrt 5.0;;
mysqrt 612.0;;