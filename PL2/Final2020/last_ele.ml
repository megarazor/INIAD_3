let rec last l =
  match l with
    [] -> None
  | [last_ele] -> Some last_ele
  | hd::tl -> last tl
;;

last [ "a" ; "b" ; "c" ; "d" ];;
last [];;
last [0, 2, 4, -1];;
last [0; 2; 4; -1];; (* Ocaml array elements are seperated by ;, not comma *)