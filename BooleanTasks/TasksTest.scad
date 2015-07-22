union()  {
union()  {
cylinder(r=2.0,h=4.0);
translate([0.0,0.0,-2.0])  cube([10.0,5.0,2.0]);
}
translate([180.0,0.0,0.0])  rotate([0.0,5.0,0.0])  union()  {
cube([1.0,2.0,3.0]);
translate([0.0,0.0,-2.0])  cube([10.0,5.0,2.0]);
}
}
