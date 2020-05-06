let length list =
  List.fold_left (fun n _ -> n + 1) 0 list
;;

length [1];;
length [1;2;3];;
length [];;