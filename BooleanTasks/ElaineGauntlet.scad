difference()  {
union()  {
translate([0.0,0.0,0.0])  difference()  {
cylinder(r1=47.563385,r2=45.971836,h=30.0);
cylinder(r1=44.563385,r2=42.971836,h=30.0);
}
translate([0.0,0.0,30.0])  difference()  {
cylinder(r1=45.971836,r2=44.698597,h=30.0);
cylinder(r1=42.971836,r2=41.698597,h=30.0);
}
translate([0.0,0.0,60.0])  difference()  {
cylinder(r1=44.698597,r2=41.197186,h=30.0);
cylinder(r1=41.698597,r2=38.197186,h=30.0);
}
translate([0.0,0.0,90.0])  difference()  {
cylinder(r1=41.197186,r2=38.809864,h=30.0);
cylinder(r1=38.197186,r2=35.809864,h=30.0);
}
translate([0.0,0.0,120.0])  difference()  {
cylinder(r1=38.809864,r2=34.83099,h=30.0);
cylinder(r1=35.809864,r2=31.830988,h=30.0);
}
translate([0.0,0.0,150.0])  difference()  {
cylinder(r1=34.83099,r2=29.260565,h=30.0);
cylinder(r1=31.830988,r2=26.260565,h=30.0);
}
}
translate([-47.56338,-47.56338,0.0])  cube([95.12676,47.56338,210.0]);
}
