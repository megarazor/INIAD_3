let pyramid rows =
  let rec draw n row_count row_num =
    if row_count <= row_num then
      let asterisk = (String.make n '*') in
        let space = (String.make (((row_num * 2 - 1) - n) / 2) ' ') in
          Printf.printf "%s" space;
          Printf.printf "%s" asterisk;
          Printf.printf "%s\n" space;
          draw (n + 2) (row_count + 1) row_num
    else ()
  in draw 1 1 rows
;;

pyramid 5;;
pyramid 20;;