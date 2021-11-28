import { render } from '@testing-library/react';
import React from 'react';
import ReactDOM from 'react-dom';
// import formik to manage form related features
import {useFormik} from 'formik'


// the API urls
var url = "http://168.138.176.208/fibonacci";
//var url_dropwiz_api="http://localhost:9090/fibonacci/";



const DataElement=()=>{
  const formik = useFormik({
    initialValues:{
      elements:10
    },
    onSubmit:values=>{
      console.log(JSON.stringify(values));

      // making POST request to the API url
      var xhr = new XMLHttpRequest();
      xhr.open("POST", url);
      xhr.setRequestHeader("Accept", "application/json");
      xhr.setRequestHeader("Content-Type", "application/json");

      xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            console.log(xhr.status);
            console.log(xhr.responseText);

            // show the reponse to the user
            alert(xhr.responseText)
                      
        }};

      var payload = JSON.stringify(values);

      xhr.send(payload);
    }

  });

  return (
    // the HTML page

    <div class="text">
      
      <h2>Compute Fibonacci Sequence</h2>
      <p>The Fibonacci sequence is&nbsp;<strong>a set of numbers that 
        starts with a one or a zero, followed by a one</strong>, 
        and proceeds based on the rule that each number (called a Fibonacci number) 
        is equal to the sum of the preceding two numbers.
        </p>

      <form onSubmit={formik.handleSubmit}>
      <p>
          <label htmlFor="elements">Elements :</label>
          <input type="number" min="1" max="100" name="elements" id="elements" value = {formik.values.elements}
          onChange={formik.handleChange}></input>
        </p>
        <button  type="submit" >Compute</button>
      </form>

      <p>Please note that element value above 20 may take longer to load, so please be paitent.
        </p>
    </div>
  )
}



const element=<DataElement></DataElement>
ReactDOM.render(element,document.getElementById("root"));

