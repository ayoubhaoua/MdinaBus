
 var drawControls,geom,lineLayer;
 var apiKey = "Au2r8DSGmoBKWxlwGjGhci4nUNGzfpuPJujkqsFwEw6D1zY3rLRhA4Y8JLWUCKVe";
 

            function init(){
                map = new OpenLayers.Map('map');
                console.log(kml);
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

                map.addLayers([wmsLayer]);
                var center = new OpenLayers.LonLat(-7.60,33.58);
                center.transform(new OpenLayers.Projection("EPSG:4326"), map.getProjectionObject());
                map.setCenter(center,12);
           	    
           	 //map.addControl(new OpenLayers.Control.LayerSwitcher());
             map.addControl(new OpenLayers.Control.MousePosition());
             lineLayer = new OpenLayers.Layer.Vector("Line Layer");
             drawControls = new OpenLayers.Control.DrawFeature(lineLayer,
                     OpenLayers.Handler.Path)
             
               
              drawControls.events.register('featureadded', drawControls, function(evt) {
               geom = evt.feature.geometry;
              for(var key in geom.components)
                  p=p+geom.components[key].x+" "+geom.components[key].y+",";
              
                   var polygone = p.substring(0, p.lastIndexOf(","));
                  polygone=polygone+")";
                   var kmg= geom.getLength()*100;
                   
                 $('#geom0').val(polygone);
             	$('#km0').val(kmg.toPrecision(4));
             	 console.log(polygone);
             });
            }
            function ajouter() {
                if(kml==null){
                map.addLayers(lineLayer);
                    map.addControl(drawControls);
                    p="LINESTRING(";
                    drawControls.activate();
                       
                    
            }
                else{
                	for(i=0,j=0 ; j<20 && i< kmllayer.features.length ; i++){
                		geom = kmllayer.features[i].geometry;
                		if(geom.components!=undefined){
                		idg="#geom"+j;
                		idk="#km"+j;

            			p="LINESTRING(";
                		for(var key in geom.components)
                            p=p+geom.components[key].x+" "+geom.components[key].y+",";
                        
                            polygone = p.substring(0, p.lastIndexOf(","));
                            polygone=polygone+")";
                        $(idg).val(polygone);
                       	$(idk).val(geom.getLength().toPrecision(4));
                       	j++;
                		}
                	}
                }
            }       
           