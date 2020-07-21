type hand =
  Rock       (* グー *)
| Scissors   (* チョキ *)
| Paper      (* パー *)

let janken h1 h2 =
  match h1 with
    Rock when h2 = Rock -> false
  | Rock when h2 = Paper -> false
  | Rock when h2 = Scissors -> true
  | Scissors when h2 = Paper -> true
  | Scissors when h2 = Scissors -> false
  | Scissors when h2 = Rock -> false
  | Paper when h2 = Paper -> false
  | Paper when h2 = Rock -> true
  | Paper when h2 = Scissors -> false
  | _ -> false
;;

janken Rock Paper;;
janken Scissors Paper;;
janken Paper Paper;;