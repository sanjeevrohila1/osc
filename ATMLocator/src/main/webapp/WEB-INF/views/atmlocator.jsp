<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
	     var selectedCity = $("#cityName").val();
        $.ajax({url: "api/city/" + selectedCity, success: function(result){
            display(result);
        }});
    });
});

function display(result){
	$("#resultDiv").html("<br>");
			for (var i = 0; i < result.length; i++) { 
				$("#resultDiv").append(" -- " + result[i].address.housenumber );
				$("#resultDiv").append( " ; " + result[i].address.street);
				$("#resultDiv").append( " ; " + result[i].address.city);
				$("#resultDiv").append( " ; " + result[i].address.postalcode);
		
				$("#resultDiv").append('<br><br><br>');
			}
}
</script>
</head>
<body>
<b>                    ATM Locator - Note: This is not a secured page.   <b> 
</br> </br> 
Select City <select id="cityName">
<option value="Alkmaar">Alkmaar</option>
<option value="Almelo">Almelo</option>
<option value="Almere">Almere</option>
<option value="Alphen aan den Rijn">Alphen aan den Rijn</option>
<option value="Amersfoort">Amersfoort</option>
<option value="Amstelveen">Amstelveen</option>
<option value="Amsterdam">Amsterdam</option>
<option value="Apeldoorn">Apeldoorn</option>
<option value="Appingedam">Appingedam</option>
<option value="Arnemuiden">Arnemuiden</option>
<option value="Arnhem">Arnhem</option>
<option value="Assen">Assen</option>
<option value="Bergen op Zoom">Bergen op Zoom</option>
<option value="Blokzijl">Blokzijl</option>
<option value="Bolsward">Bolsward</option>
<option value="Breda">Breda</option>
<option value="Bredevoort">Bredevoort</option>
<option value="Buren">Buren</option>
<option value="Coevorden">Coevorden</option>
<option value="Culemborg">Culemborg</option>
<option value="Deil">Deil</option>
<option value="Delft">Delft</option>
<option value="Delfzijl">Delfzijl</option>
<option value="Den Helder">Den Helder</option>
<option value="Deventer">Deventer</option>
<option value="Dieren">Dieren</option>
<option value="Doetinchem">Doetinchem</option>
<option value="Dokkum">Dokkum</option>
<option value="Dordrecht">Dordrecht</option>
<option value="Drachten">Drachten</option>
<option value="Edam, Volendam">Edam, Volendam</option>
<option value="Ede">Ede</option>
<option value="Eindhoven">Eindhoven</option>
<option value="Emmeloord">Emmeloord</option>
<option value="Emmen">Emmen</option>
<option value="Enkhuizen">Enkhuizen</option>
<option value="Enschede">Enschede</option>
<option value="Enspijk">Enspijk</option>
<option value="Franeker">Franeker</option>
<option value="Geertruidenberg">Geertruidenberg</option>
<option value="Geleen">Geleen</option>
<option value="Gendt">Gendt</option>
<option value="Genemuiden">Genemuiden</option>
<option value="Gennep">Gennep</option>
<option value="Goes">Goes</option>
<option value="Gorinchem">Gorinchem</option>
<option value="Gouda">Gouda</option>
<option value="Grave">Grave</option>
<option value="Groenlo">Groenlo</option>
<option value="Groningen">Groningen</option>
<option value="Haarlem">Haarlem</option>
<option value="Harderwijk">Harderwijk</option>
<option value="Harlingen">Harlingen</option>
<option value="Hasselt">Hasselt</option>
<option value="Hattem">Hattem</option>
<option value="Heerenveen">Heerenveen</option>
<option value="Heerhugowaard">Heerhugowaard</option>
<option value="Heerlen">Heerlen</option>
<option value="Helmond">Helmond</option>
<option value="Hengelo">Hengelo</option>
<option value="Heusden">Heusden</option>
<option value="Hilversum">Hilversum</option>
<option value="Hindeloopen">Hindeloopen</option>
<option value="homoland">homoland</option>
<option value="Hoofddorp">Hoofddorp</option>
<option value="Hoogeveen">Hoogeveen</option>
<option value="Hoogezand-Sappemeer">Hoogezand-Sappemeer</option>
<option value="Hoorn">Hoorn</option>
<option value="Huissen">Huissen</option>
<option value="Hulst">Hulst</option>
<option value="IJlst">IJlst</option>
<option value="Kampen">Kampen</option>
<option value="Kerkrade">Kerkrade</option>
<option value="Kessel">Kessel</option>
<option value="Klundert">Klundert</option>
<option value="Landgraaf">Landgraaf</option>
<option value="Laren">Laren</option>
<option value="Leeuwarden">Leeuwarden</option>
<option value="Leiden">Leiden</option>
<option value="Lelystad">Lelystad</option>
<option value="Maastricht">Maastricht</option>
<option value="Medemblik">Medemblik</option>
<option value="Meppel">Meppel</option>
<option value="Middelburg">Middelburg</option>
<option value="Monnickendam">Monnickendam</option>
<option value="Montfort">Montfort</option>
<option value="Muiden">Muiden</option>
<option value="Naarden">Naarden</option>
<option value="Nieuwegein">Nieuwegein</option>
<option value="Nieuwstadt">Nieuwstadt</option>
<option value="Nijkerk">Nijkerk</option>
<option value="Nijmegen">Nijmegen</option>
<option value="Oldenzaal">Oldenzaal</option>
<option value="Oosterhout">Oosterhout</option>
<option value="Oss">Oss</option>
<option value="Purmerend">Purmerend</option>
<option value="Ravenstein">Ravenstein</option>
<option value="Roermond">Roermond</option>
<option value="Roosendaal">Roosendaal</option>
<option value="Rotterdam">Rotterdam</option>
<option value="s-Hertogenbosch">s-Hertogenbosch</option>
<option value="Schagen">Schagen</option>
<option value="Schin op Geul">Schin op Geul</option>
<option value="Sint-Oedenrode">Sint-Oedenrode</option>
<option value="Sittard">Sittard</option>
<option value="Sloten">Sloten</option>
<option value="Sluis">Sluis</option>
<option value="Sneek">Sneek</option>
<option value="Spijkenisse">Spijkenisse</option>
<option value="Stadskanaal">Stadskanaal</option>
<option value="Stavoren">Stavoren</option>
<option value="Steenwijk">Steenwijk</option>
<option value="Stein">Stein</option>
<option value="Terneuzen">Terneuzen</option>
<option value="The Hague ">The Hague </option>
<option value="Thorn">Thorn</option>
<option value="Tiel">Tiel</option>
<option value="Tilburg">Tilburg</option>
<option value="Utrecht">Utrecht</option>
<option value="Valkenburg aan de Geul">Valkenburg aan de Geul</option>
<option value="Valkenswaard">Valkenswaard</option>
<option value="Veendam">Veendam</option>
<option value="Veenendaal">Veenendaal</option>
<option value="Veere">Veere</option>
<option value="Veldhoven">Veldhoven</option>
<option value="Velsen">Velsen</option>
<option value="Venlo">Venlo</option>
<option value="Vlissingen ">Vlissingen </option>
<option value="Vollenhove">Vollenhove</option>
<option value="Waalwijk">Waalwijk</option>
<option value="Wageningen">Wageningen</option>
<option value="Weert">Weert</option>
<option value="Weesp">Weesp</option>
<option value="Wijchen">Wijchen</option>
<option value="Willemstad">Willemstad</option>
<option value="Winschoten">Winschoten</option>
<option value="Winterswijk">Winterswijk</option>
<option value="Workum">Workum</option>
<option value="Woudrichem">Woudrichem</option>
<option value="Zaanstad">Zaanstad</option>
<option value="Zaltbommel">Zaltbommel</option>
<option value="Zierikzee">Zierikzee</option>
<option value="Zoetermeer">Zoetermeer</option>
<option value="Zutphen">Zutphen</option>
<option value="Zwolle">Zwolle</option>
</select>



<button>Search</button>
<h2>List Of ING ATMs</h2>
<div id="resultDiv"></div>
</body>
</html>