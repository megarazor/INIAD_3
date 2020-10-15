module Turtle : 
  sig
    type t
    val create : unit -> t
    val forward : float -> t -> unit
    val left : float -> t -> unit
    val position : t -> float * float
  end =
  struct
    type t = { mutable x : float; mutable y : float; mutable angle : float }

    let create () =
      { x = 0.0; y = 0.0; angle = 0.0 }

    let forward d ttl =
      begin
      ttl.x <- ttl.x +. d *. (cos ttl.angle);
      ttl.y <- ttl.y +. d *. (sin ttl.angle);
      end

    let left a ttl =
      ttl.angle <- ttl.angle +. (a /. 180.0 *. 3.14159)
      
    let position ttl =
      (ttl.x, ttl.y)
  end

  let kame = Turtle.create ();;
  Turtle.position kame;;
  Turtle.forward 100.0 kame;;
  Turtle.position kame;;
  Turtle.left 45.0 kame;;
  Turtle.forward 200.0 kame;;
  Turtle.position kame;;
  (* - : float * float = (241.421450055845241, 141.421262418711507) *)