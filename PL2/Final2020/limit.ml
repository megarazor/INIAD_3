let limit xs n =
  let rec iter xs res n i =
    match xs with
      hd::tl when i < n -> res @ [hd] @ iter tl res n (i + 1)
    | hd::tl when i >= n -> res
    | [] -> res
    | [last] -> res @ [last]
  in iter xs [] n 0
;;

limit [1;2;3;4;5] 3;;
limit ["Information"; "Networking"; "for"; "Innovation"; "and"; "Design"] 4;;
limit [1;2;3] 6;;
limit [1] 3;;
limit [] 2;;