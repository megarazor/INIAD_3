let combination xs n = 
  let rec iter xs ls n' =
    if n' <= 0 then ls
    else match ls with
      hd::tl -> iter tl (ls @ [hd]) (n' - 1)
    | [] -> ls
  in iter xs [] (n)