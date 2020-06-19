let rec apply (f: 'a -> 'a) n =
  let rec iter newf i =
    if i <= 0 then 
      newf
    else
      iter (fun newf -> f newf) (i - 1)
  in iter f n
;;

let newton_map x f df =
  x -. f(x) /. df(x)
;;

let newton =
  apply newton_map 1000
;;


let rec mysqrt a =
  (* let f = (fun x -> x -. (x *. x -. a) /. (2.0 *. x)) in
    (apply f 100) a *)
  let f x =
    x *. x -. 2.0
  in let df x =
    2.0 *. x
  in
    newton
;;

mysqrt 2.0;;
mysqrt 3.0;; 
