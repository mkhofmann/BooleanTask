union()  {
translate([-25.0,-25.0,20.0])cube([50.0,50.0,5.0]);
translate([0.0,0.0,0.0])scale([1.0,1.0,1.0])cube([0.0,0.0,0.0]);
union()  {
translate([-25.0,-25.0,20.0])cube([20.0,20.0,5.0]);
translate([-15.0,-15.0,20.0])scale([1.0,1.0,1.0])union()  {
difference()  {
cylinder(r=10.0,h=30.0);
rotate([0.0,10.0,0.0])  translate([0.0,10.0,15.0])sphere(r = 2.0);
rotate([0.0,10.0,90.0])  translate([0.0,10.0,15.0])sphere(r = 2.0);
rotate([0.0,10.0,180.0])  translate([0.0,10.0,15.0])sphere(r = 2.0);
rotate([0.0,10.0,270.0])  translate([0.0,10.0,15.0])sphere(r = 2.0);
}
cylinder(r=5.0,h=70.0);
}
}
}
