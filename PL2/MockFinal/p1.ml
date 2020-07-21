let range n m =
  let rec iter n' m' res =
    if n' < m' then iter (n' + 1) m' (res @ [n'])
    else res
  in iter n m []
;;

range 5 10;;