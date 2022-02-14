import React from "react";
import { Link } from "react-router-dom";
import Echo from '../utils/echo';
import usePlatform from "../hooks/usePlaform";

async function ecP1(android) {
    if (android){
        console.log('I have been called')
  const { value } = await Echo.echo({ value: 'Hello World!' });
  console.log('Response from native:', value);
    }
    return;
} 
 const Page1 = () => {
    const { isNativeDevice } = usePlatform();
    
    return(
        <div>
            <h1>Page1</h1>
            <p>Lorem ipsum generator</p>
          <button onClick= { () => ecP1(isNativeDevice)} > Echo called</button>

      </div>
    )
}

export default Page1;