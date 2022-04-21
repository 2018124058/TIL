let childWindow; 

function createChildWindow()
{
    let toolBar, menuBar, location, scrollBars, status, resizable;
    if (toolBarCheckBox.checked) toolBar = "yes"; else toolBar = "no";
    if (menuBarCheckBox.checked) menuBar = "yes"; else menuBar = "no";
    if (locationCheckBox.checked) location = "yes"; else location = "no";
    if (scrollBarsCheckBox.checked) scrollBars = "yes"; else scrollBars = "no";
    if (statusCheckBox.checked) status = "yes"; else status = "no";
    if (resizableCheckBox.checked) resizable = "yes"; else resizable = "no";

    childWindow = window.open("", "_blank", "resizable =" + resizable + ",toolbar = " + toolBar +
    ", menubar = " + menuBar + ", status = " + status + ", location = " + location + ",scrollbars = "
    + scrollBars); 
    
    closeButton.disabled = false; 
    modifyButton.disabled = false;
    setURLButton.disabled = false;
}

function modifyChildWindow()
{
    if (childWindow.closed)
        alert("you attempted to interact with a closed window")
    else
        childWindow.document.write(textForChild.value);
}

function closeChildWindow()
{
    if (childWindow.closed)
        alert("you attempted to interact with a closed window")
    else
        childWindow.close();

    closeButton.disabled = true;
    modifyButton.disabled = true;
    setURLButton.disabled = true;
}

function setChildWindowURL()
{
    if (childWindow.closed)
        alert("you attempted to interact with a closed window")
    else
        childWindow.location = myChildURL.value;
}