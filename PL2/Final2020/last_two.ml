let rec last_two l =
  match l with
    [] -> None
  | [last_ele] -> None
  | [x; y] -> Some (x, y)
  | hd::tl -> last_two tl
;;

last_two  [ "a" ; "b" ; "c" ; "d" ];;
last_two  ["a"];;
last_two  [0, 2, 4, -1];;
last_two  [0; 2; 4; -1];; (* Ocaml array elements are seperated by ;, not comma *)