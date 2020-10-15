let rec square_list l = 
  match l with
    hd::tl -> [hd *. hd] @ (square_list tl)
  | [] -> []
;;

square_list [1.0; 2.0; 3.0];;
square_list [-9.0; -2.0; 5.0];;