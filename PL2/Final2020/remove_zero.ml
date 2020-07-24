let rec remove_zero_original numbers = 
  match numbers with
    0::tl -> remove_zero_original tl
  | hd::tl -> hd::(remove_zero_original numbers)
  | [] -> []
;;

let remove_zero numbers = 
  let rec iter numbers res =
    match numbers with
      0::tl -> iter tl res
    | hd::tl -> res @ [hd] @ (iter tl res)
    | [] -> res
  in iter numbers []
;;

remove_zero_original [2; 0; 2; 10];;
remove_zero_original [0];;
remove_zero_original [];;

(* remove_zero [2; 0; 2; 10];;
remove_zero [0];;
remove_zero [];; *)
