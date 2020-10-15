let printchars str =
  let rec iter i =
    Printf.printf "%c\n" str.[i]; 
    if i < (String.length str) then iter (i + 1)
  in iter 0
;;

printchars "bruh moment"