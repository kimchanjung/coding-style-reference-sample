import React, { useState } from 'react';
import axios from 'axios';

export default function Crawling() {
    const [url, setUrl] = useState("");
    const [parsingType, setParsingType] = useState("WITHOUT_TAG");
    const [bundleUnit, setBundleUnit] = useState(0);

    const handleSubmit = (event) => {
        event.preventDefault()
        alert(`URL: ${url} -  ${parsingType} -  ${bundleUnit}`);


        axios.post('/api/v1/crawling', {
            url: url,
            parsingType: parsingType,
            bundleUnit:bundleUnit
          })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
    }




    return (
        <div>
            <form name="crawling" onSubmit={handleSubmit}>
                <div>
                    <p>URL &nbsp;<input name="url" id="url" type="text" onChange={({ target: { value } }) => setUrl(value)}/></p>
                    <p>TYPE &nbsp;
                        <select name="parsingType" id="parsingType" onChange={({ target: { value } }) => setParsingType(value)}>
                            <option value="WITHOUT_TAG">HTML TAG 제외 </option>
                            <option value="TEXT_ALL">텍스트전체</option>
                        </select>
                    </p>
                    <p>출력묶음단위 &nbsp;<input name="bundleUnit" id="bundleUnit" type="number" onChange={({ target: { value } }) => setBundleUnit(value)}/></p> 
                    <p><button name="print" id="print" type="submit" >출력</button></p> 
                </div>
            </form>
            <div>
                <p>몫</p>
                <span></span>
                <p>나머지 </p>
                <span></span>
            </div>
        </div>
  )
}

