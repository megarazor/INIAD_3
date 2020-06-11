(* OCaml *)

let checkab s =
  let rec check i state =
    if i > (String.length s - 1) then false else
    match state with
      0 -> if s.[i] = 'a' then check (i+1) 1 else false
    | 1 -> if s.[i] = 'a' then check (i+1) 2
           else if s.[i] = 'b' then true
           else false
    | _ -> if s.[i] = 'a' then check (i+1) 2
           else if s.[i] = 'b' then true
           else false
  in check 0 0
;;


checkab "a";;
checkab "ab";;
checkab "aab";;
checkab "aaab";;
checkab "aaaaaaaab";;