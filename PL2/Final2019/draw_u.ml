let rec draw_u h =
  if h > 0 then
    begin
      Printf.printf "# #\n"; draw_u (h - 1)
    end
  else Printf.printf "###\n"; ()
;;

draw_u 3;;
draw_u 5;;