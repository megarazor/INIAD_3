type lat_lng =
  float * float
;;

type lat_lng_op =
  Values of lat_lng
| Null
;;

let north_of_iniad values = 
  match values with
    Values(coord) ->
      begin
        match coord with
          (lat, lng) when lat > 35.780246 -> Some(true)
        | _ -> Some(false)
      end
  | _ -> None
;;

north_of_iniad (Values(35.777615, 139.7209868));;
north_of_iniad (Null);;
north_of_iniad ;;