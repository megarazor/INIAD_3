let length list =
  let rec length_iter list n =
    match list with
      hd::tl -> length_iter tl (n + 1)
    | [] -> n
  in length_iter list 0
;;

length [1];;
length [1;2;3];;
length [];;