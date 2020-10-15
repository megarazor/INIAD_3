let remove ls n = 
  let rec iter res l i =
    match l with
      hd::tl -> 
        if i != n then iter (res @ [hd]) tl (i + 1)
        else iter (res) tl (i + 1)
      | [] -> res
  in iter [] ls 0
;;

remove [1; 2; 3; 4; 5; 6] 3;;
remove [1; 2; 3; 4; 5; 6] 0;;