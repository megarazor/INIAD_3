let rec histogram xs =
  match xs with
    hd::tl -> 
      if hd >= 0 then
        Printf.printf "%s\n" (String.make hd '*'); (histogram tl)
      (* else Printf.printf "\n"; () *)
  | [] -> ()
;;

histogram [3;7;5;1];;
histogram [0;0;3;-2];;