let digit n =
  let rec digit_iter n s d =
    if n <= 0 then s
    else
      let n'= n / 10 in
        digit_iter n' (s + 1) (d * 10)
  in digit_iter n 0 10
;;

digit 114235;;
digit 11400;;
digit 2;;
digit 12;;