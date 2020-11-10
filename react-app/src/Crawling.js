import React, { useState } from 'react';
import axios from 'axios';

export default function Crawling() {
    const [url, setUrl] = useState("http://www.naver.com");
    const [parsingTypes, setParsingTypes] = useState("WITHOUT_TAG");
    const [bundleUnit, setBundleUnit] = useState(2);

    const [quotient, setQuotient] = useState("");
    const [remainder, setRemainder] = useState("");


    const handleSubmit = (event) => {
        event.preventDefault()
      
        axios.post('/api/v1/crawling', {
            url: url,
            parsingTypes: parsingTypes,
            bundleUnit: bundleUnit
        })
        .then(function (response) {
            console.log(response);
            const {quotient, remainder} = response.data;

            setQuotient(quotient);
            setRemainder(remainder)

        })
        .catch(function (error) {
            console.log(error.response);
            alert(error.response.data.message);
        });
    }

    return (
        <div>
            <form name="crawling" onSubmit={handleSubmit}>
                <div style={{textAlign:"left"}}>
                    <p>URL &nbsp;<input name="url" id="url" type="text" onChange={({ target: { value } }) => setUrl(value)} value={url}/></p>
                    <p>TYPE &nbsp;
                        <select name="parsingTypes" id="parsingTypes" onChange={({ target: { value } }) => setParsingTypes(value)}>
                            <option value="WITHOUT_TAG" >HTML TAG 제외 </option>
                            <option value="TEXT_ALL">텍스트전체</option>
                        </select>
                    </p>
                    <p>출력묶음단위 &nbsp;<input name="bundleUnit" id="bundleUnit" type="number" onChange={({ target: { value } }) => setBundleUnit(value)} value={bundleUnit}/></p> 
                    <p><button name="print" id="print" type="submit" style={{fontSize:"20px"}} >출력</button></p> 
                </div>
            </form>
            <div style={{textAlign:"left", width:"500px"}}>
                <p>몫</p>
                <div style={{padding:"50px"}}>{quotient}</div>
                <p>나머지 </p>
                <div style={{padding:"50px"}} id="riderName">{remainder}</div>
            </div>
        </div>
  )
}

