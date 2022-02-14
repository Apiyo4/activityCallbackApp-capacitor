import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import './App.css';
import Page1 from './components/Page1';
import Page2 from './components/Page2';

function App() {
  return (
    <Router>
        <Routes>
        <Route path="/" element={<Page1/>} />
      </Routes>
  </Router>
  );
}

export default App;









// import React from "react";
// import {
//   BrowserRouter as Router,
//   Routes,
//   Route,
//   Link
// } from "react-router-dom";
// import Page1 from './components/Page1';
// import Page2 from './components/Page2';
// import './index.css';

// function App() {
//   return (
  //   <Router>
    

  //     <Routes>
  //       <Route path="/page2" component={Page2}>
  //         <Page2 />
  //       </Route>
        
  //       <Route path="/" component={Page1}>
  //         <Page1 />
  //       </Route>
  //     </Routes>
  // </Router>
//   );
// }

// export default App;

