
 var drawControls,geom;

            function init(){
                map = new OpenLayers.Map('map');

                var wmsLayer = new OpenLayers.Layer.WMS( "OpenLayers WMS",
                    "http://vmap0.tiles.osgeo.org/wms/vmap0?", {layers: 'basic'});
                map.addLayer(wmsLayer);
           	    map.setCenter(new OpenLayers.LonLat(-7.13,33.67), 7);
                console.log(kml);
            }
            function ajouter() {
                if(kml==null){
                var lineLayer = new OpenLayers.Layer.Vector("Line Layer");
                map.addLayers(lineLayer);
                map.addControl(new OpenLayers.Control.LayerSwitcher());
                map.addControl(new OpenLayers.Control.MousePosition());

                drawControls = new OpenLayers.Control.DrawFeature(lineLayer,
                        OpenLayers.Handler.Path)

                  var p="LINESTRING("
                 drawControls.events.register('featureadded', drawControls, function(evt) {
                  geom = evt.feature.geometry;
                 for(var key in geom.components)
                     p=p+geom.components[key].x+" "+geom.components[key].y+",";
                 
                     var poly = p.substring(0, p.lastIndexOf(","));
                     poly=poly+")";
                     var km= geom.getLength();
                    $('#geometry').val(poly);
                	$('#km').val(km);
                        
                });

                    map.addControl(drawControls);
                        drawControls.activate();
                       
                    
            }
                else{
                	
                	 
                	 geom = kmllayer.features[0].geometry;
                	 for(var key in geom.components)
                         p=p+geom.components[key].x+" "+geom.components[key].y+",";
                     
                         var poly = p.substring(0, p.lastIndexOf(","));
                         poly=poly+")";
                        $('#geometry').val(poly);
                    	$('#km').val(geom.getLength());
                }
            }       
           