type location =    
  LatLng of { lat : float; lng : float; }  
| Place of { name : string; }
;;

type way = Walk | Fly | Car | Train
;;

let duration way p1 p2 =
  match p1, p2 with
    LatLng({lat = lat1; lng = lng1}), LatLng({lat = lat2; lng = lng2}) -> 
    begin
      let distance = sqrt(abs_float(lat1 -. lat2) ** 2.0 +. abs_float(lng1 -. lng2) ** 2.0)
      in match way with
        Walk -> distance /. 4.0
      | Fly -> distance /. 800.0
      | Car -> distance /. 50.0
      | Train -> distance /. 90.0
    end
  | _, _ -> failwith "Error"
;;

let p1= LatLng({lat = 10.0; lng = 20.0});;
let p2= LatLng({lat = 20.0; lng = 5.0});;

duration Walk p1 p2 ;;
(* 
duration  *)