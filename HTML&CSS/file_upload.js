var input = document.getElementById("file-input");
input.addEventListener("change", updateFileName, false);

function updateFileName() {
  let holder = document.getElementById("file-name-holder");
  let fileName = input.files[0]
              ? input.files[0].name
              : "&nbsp;";
  holder.innerHTML = fileName;
}
