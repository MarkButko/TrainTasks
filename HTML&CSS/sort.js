
table = document.getElementById("data");
var rows = table.rows;

for (let i = 0; i < rows[0].getElementsByTagName("th").length - 1; i++) {
  rows[0].getElementsByTagName("th")[i]
  .addEventListener("click", function(){ sort(i) }, false);
  rows[0].getElementsByTagName("th")[i].style.cursor = "pointer";
}

var filterFloat = function (value) {
    if(/^(\-|\+)?([0-9]+(\.[0-9]+)?)$/
      .test(value))
      return Number(value);
  return NaN;
}

function sort(columnNumber, direction) {
  let switchCount = 0;
  let sortDirection = direction || "asc";

  //check if column contains numbers
  let getRowData = isNaN(filterFloat(getRow(1).getElementsByTagName("td")[columnNumber].innerHTML))
          ? getRowDataAsString
          : getRowDataAsNumber;

  for (let i = 1; i < rows.length; i++) {
    let temp = i;
    for (let j = i + 1; j < rows.length; j++) {
      if ((sortDirection === "asc" && (getRowData(j) < getRowData(temp)))
       || (sortDirection === "desc" && (getRowData(j) > getRowData(temp)))) {
        temp = j;
        switchCount++;
      }
    }
    getRow(temp).parentNode.insertBefore(getRow(temp) , getRow(i));
  }

  if (switchCount === 0) {
    sort(columnNumber, "desc");
  }

  function getRowDataAsNumber(rowNumber) {
    return +getRow(rowNumber).getElementsByTagName("td")[columnNumber].innerHTML;
  }

  function getRowDataAsString(rowNumber) {
    return getRow(rowNumber).getElementsByTagName("td")[columnNumber].innerHTML;
  }

  function getRow(rowNumber) {
    return rows[rowNumber]
  }
}
