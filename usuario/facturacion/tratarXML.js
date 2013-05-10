function AbrirFichero(fichXML)
{
        var xmlDoc=undefined;
        try
        {
            if (document.all) //IE
            {
                xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            }
            else //firefox
            {
                xmlDoc = document.implementation.createDocument("","",null);
            }
            xmlDoc.async=false;
            xmlDoc.load(fichXML);
             
             
        }
        catch(e)
        {
            try { //otros safari, chrome
                    var xmlhttp = new window.XMLHttpRequest();
                    xmlhttp.open("GET",fichXML,false);
                    xmlhttp.send(null);
                    xmlDoc = xmlhttp.responseXML.documentElement;
                    return xmlDoc;
            }
            catch (e)
            {
                return undefined;
            }
         
        }
        return xmlDoc;
}