function Factura(fecha1,fecha2,nombre,apellidos,direccion,subtotal,iva,total){
    this.fecha1 = fecha1;
    this.fecha2 = fecha2;
    this.nombre = nombre;
	this.apellidos = apellidos;
    this.direccion = direccion;
    this.subtotal = subtotal;
	this.iva = iva;
	this.total = total;
}

function CargarXMLFacturas(ind){
    try{
        xmlDoc=AbrirFichero("facturacion.xml");
        facturasXML=xmlDoc.getElementsByTagName('factura');
        facturas=new Array(); //clase con los datos cargados
            xmlFactura=facturasXML[ind];
 
            fecha1 = xmlFactura.getElementsByTagName("Fecha1")[0].firstChild.nodeValue;
            fecha2 = xmlFactura.getElementsByTagName("Fecha2")[0].firstChild.nodeValue;
            nombre = xmlFactura.getElementsByTagName("Nombre")[0].firstChild.nodeValue;
			apellidos = xmlFactura.getElementsByTagName("Apellidos")[0].firstChild.nodeValue;
            direccion = xmlFactura.getElementsByTagName("Direccion")[0].firstChild.nodeValue;
            subtotal = xmlFactura.getElementsByTagName("Subtotal")[0].firstChild.nodeValue;
			iva = xmlFactura.getElementsByTagName("IVA")[0].firstChild.nodeValue;
			total = xmlFactura.getElementsByTagName("Total")[0].firstChild.nodeValue;
						
            factura = new Factura(fecha1,fecha2,nombre,apellidos,direccion,subtotal,iva,total);      
            facturas.push(factura);

        return facturas;
    }
    catch(e){
        alert("Se produjo un error en la carga de los datos");
    }   
 
}

function cargarFactura(ind){
        var tr;
        var td;
        var tabla;
        ev= CargarXMLFacturas(ind);
		if(ev){
			auxUnEven=ev.pop();
			document.getElementById('hFactura').innerHTML = "Fecha Factura: " + auxUnEven.fecha1 + " - " + auxUnEven.fecha2;
			tabla = document.getElementById("tFactura");
			tabla.innerHTML = "";
				tr=tabla.insertRow(0);
					td=tr.insertCell(0);
					td.className = "campoFactura";
					td.innerHTML = "Nombre";
					td=tr.insertCell(1);
					td.className = "infoFactura";
					td.innerHTML = auxUnEven.nombre;
				tr=tabla.insertRow(1);
					td=tr.insertCell(0);
					td.className = "campoFactura";
					td.innerHTML = "Apellidos";
					td=tr.insertCell(1);
					td.className = "infoFactura";
					td.innerHTML = auxUnEven.apellidos;
				tr=tabla.insertRow(2);
					td=tr.insertCell(0);
					td.className = "campoFactura";
					td.innerHTML = "Direccion";
					td=tr.insertCell(1);
					td.className = "infoFactura";
					td.innerHTML = auxUnEven.direccion;
				tr=tabla.insertRow(3);
					td=tr.insertCell(0);
					td.className = "campoFactura";
					td.innerHTML = "Subtotal";
					td=tr.insertCell(1);
					td.className = "infoFactura";
					td.innerHTML = auxUnEven.subtotal;
				tr=tabla.insertRow(4);
					td=tr.insertCell(0);
					td.className = "campoFactura";
					td.innerHTML = "IVA";
					td=tr.insertCell(1);
					td.className = "infoFactura";
					td.innerHTML = auxUnEven.iva;
				tr=tabla.insertRow(5);
					td=tr.insertCell(0);
					td.className = "campoFactura";
					td.innerHTML = "Total";
					td=tr.insertCell(1);
					td.className = "infoFactura";
					td.innerHTML = auxUnEven.total;
		}
}