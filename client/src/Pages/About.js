import MainMenu from '../Components/MainMenu';

function About() {


  return (

    <div className="w-full h-screen bg-gray-800 flex flex-col items-center justify-center">
      <MainMenu/>
      <h1 className="text-white text-5xl font-bold mt-1 mb-10 font-serif ">Rent A Car App</h1>
      <div className="flex flex-col items-center font-serif w-5/6">
        <h1 className="text-white text-3xl mt-5 font-serif">Biz Kimiz?</h1>
        <p className="text-white text-md mt-5 text-center">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolores
          vero, perspiciatis soluta iure consequatur minima consectetur hic
          sequi exercitationem cum unde ea repellat natus maxime error molestiae
          ducimus porro suscipit? Lorem, ipsum dolor sit amet consectetur
          adipisicing elit. Aliquid odit ut porro omnis veniam dicta harum
          asperiores ipsa dolorum cupiditate laborum ex sunt, itaque illo quas
          eveniet, sed delectus quasi?
        </p>
      </div>
      <div className="flex flex-col items-center font-serif w-5/6">
        <h1 className="text-white text-3xl mt-5">Misyon ve Vizyon</h1>
        <p className="text-white text-md mt-5 text-center">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolores
          vero, perspiciatis soluta iure consequatur minima consectetur hic
          sequi exercitationem cum unde ea repellat natus maxime error molestiae
          ducimus porro suscipit? Lorem, ipsum dolor sit amet consectetur
          adipisicing elit. Aliquid odit ut porro omnis veniam dicta harum
          asperiores ipsa dolorum cupiditate laborum ex sunt, itaque illo quas
          eveniet, sed delectus quasi?
        </p>
      </div>
      <div className="flex flex-col items-center font-serif w-5/6">
        <h1 className="text-white text-3xl mt-5">Yönetim Kurulu</h1>
        <p className="text-white text-md mt-5 text-center">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolores
          vero, perspiciatis soluta iure consequatur minima consectetur hic
          sequi exercitationem cum unde ea repellat natus maxime error molestiae
          ducimus porro suscipit? Lorem, ipsum dolor sit amet consectetur
          adipisicing elit. Aliquid odit ut porro omnis veniam dicta harum
          asperiores ipsa dolorum cupiditate laborum ex sunt, itaque illo quas
          eveniet, sed delectus quasi?
        </p>
      </div>
    </div>
);


}

export default About;