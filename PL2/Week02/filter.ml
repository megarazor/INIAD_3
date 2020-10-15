let filter f xs =
  let rec filter_iter pxs res = 
    match pxs with 
      hd::tl -> if (f hd) then filter_iter tl (res @ [hd]) else filter_iter tl res
    | [] -> res
  in filter_iter xs []
;;

filter (fun x -> x mod 2 = 0) [1;2;3;4;5];;