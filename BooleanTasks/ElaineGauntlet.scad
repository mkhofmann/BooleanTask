difference()  {
union()  {
translate([0.0,0.0,0.0])  difference()  {
cylinder(r1=38.014088,r2=39.605637,h=30.0);
cylinder(r1=35.014088,r2=36.605637,h=30.0);
}
translate([0.0,0.0,30.0])  difference()  {
cylinder(r1=39.605637,r2=39.605637,h=30.0);
cylinder(r1=36.605637,r2=36.605637,h=30.0);
}
translate([0.0,0.0,60.0])  difference()  {
cylinder(r1=39.605637,r2=38.014088,h=30.0);
cylinder(r1=36.605637,r2=35.014088,h=30.0);
}
translate([0.0,0.0,90.0])  difference()  {
cylinder(r1=38.014088,r2=34.83099,h=30.0);
cylinder(r1=35.014088,r2=31.830988,h=30.0);
}
translate([0.0,0.0,120.0])  difference()  {
cylinder(r1=34.83099,r2=30.056341,h=30.0);
cylinder(r1=31.830988,r2=27.056341,h=30.0);
}
translate([0.0,0.0,150.0])  difference()  {
cylinder(r1=30.056341,r2=28.46479,h=30.0);
cylinder(r1=27.056341,r2=25.46479,h=30.0);
}
}
translate([-39.605637,-39.605637,0.0])  cube([79.21127,39.605637,210.0]);
}
