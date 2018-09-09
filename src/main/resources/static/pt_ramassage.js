var map, drawControls, kmllayer;
var apiKey = "Au2r8DSGmoBKWxlwGjGhci4nUNGzfpuPJujkqsFwEw6D1zY3rLRhA4Y8JLWUCKVe";

            function init(){
                map = new OpenLayers.Map('map');

                var wmsLayer = new OpenLayers.Layer.WMS( "OpenLayers WMS",
                    "http://vmap0.tiles.osgeo.org/wms/vmap0?", {layers: 'basic'});
                var road = new OpenLayers.Layer.Bing({
                    key: apiKey,
                    type: "Road",
                    
                    metadataParams: {mapVersion: "v1"}
                });
                var aerial = new OpenLayers.Layer.Bing({
                    key: apiKey,
                    type: "Aerial"
                });
                var hybrid = new OpenLayers.Layer.Bing({
                    key: apiKey,
                    type: "AerialWithLabels",
                    name: "Bing Aerial With Labels"
                });

               

                var pointLayer = new OpenLayers.Layer.Vector("Point Layer");

                map.addLayers([road, aerial, hybrid, pointLayer]);
                //map.addControl(new OpenLayers.Control.LayerSwitcher());
                map.addControl(new OpenLayers.Control.MousePosition());

                drawControls = new OpenLayers.Control.DrawFeature(pointLayer, OpenLayers.Handler.Point);


                 drawControls.events.register('featureadded', drawControls, function(evt) {
                 var geom = evt.feature.geometry;
                        $('#geometry').val("POINT("+geom.x+" "+geom.y+")");
                        $('#exampleModalLong').modal();
                        
                });

                    map.addControl(drawControls);
                    
                    var center = new OpenLayers.LonLat(-7.60,33.58);
                    center.transform(new OpenLayers.Projection("EPSG:4326"), map.getProjectionObject());
                    map.setCenter(center,12);
                    
                    
                    $("#ajouter").click(function() {
                        drawControls.activate();
                       });
                    
            }
            
            
            